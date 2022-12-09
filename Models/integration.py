# -*- coding: utf-8 -*-
"""
Created on Tue Nov  1 18:30:15 2022

@author: disha
"""

from flask import Flask, request, jsonify
import pickle
import numpy as np
from flask_cors import CORS, cross_origin
from keras.models import Model, load_model
from keras_preprocessing.sequence import pad_sequences

app = Flask(__name__)
app.config['SECRET_KEY'] = 'the quick brown fox jumps over the lazy   dog'
app.config['CORS_HEADERS'] = 'Content-Type'

cors = CORS(app, resources={r"/predict": {"origins": "http://localhost:port"}})

model = pickle.load(open('rf_model_corrected.pkl', 'rb'))


@app.route("/predict", methods=['POST'])
@cross_origin(origin='localhost',headers=['Content- Type','Authorization'])
def predict():  #to bind a function to a url
    content_type = request.headers.get('Content-Type')
    if (content_type == 'application/json'):
        json = request.json
        input_ = np.array([[int(json[i]) for i in json]])
        pred = model.predict(input_)
        
        return str(pred)
    else:
        return 'Content-Type not supported!'
    
@app.route("/illness", methods=['POST'])
@cross_origin(origin='localhost',headers=['Content- Type','Authorization'])
def speech():  #to bind a function to a url
    # content_type = request.headers.get('Content-Type')
    # if (content_type == 'application/json'):
        sample_ = request.json
        result = predict_cnn((sample_["text"]))
        if len(result) == 0: 
            result = ['generic']
        data = {"category":result}
        print(jsonify(data))
        return jsonify(data)
    # else:
    #     return 'Content-Type not supported!'
    
def predict_cnn(sample_):
    target_encode = {'depression':0,       
    'generic':1,       
    'adhd':2,             
    'antisocial':3,        
    'ocd':4,               
    'suicide':5,          
    'eatingdisorder':6,     
    'anxiety':7}
    model = load_model('cnn_text.h5')
    #to do: preprocess inputs
    
    #load tokenizer
    with open('tokenizer.pickle', 'rb') as handle:
        tokenizer = pickle.load(handle)
    text_ = tokenizer.texts_to_sequences([sample_])
    data_ = pad_sequences(text_, maxlen=100)
    pred = model.predict(data_)
    pred_list = list(np.argwhere(pred>0.3).flatten())
    tags=[]
    for n in pred_list:
        tags.append((list(target_encode.keys())[n]))
    return tags

    
if __name__ == "__main__":
    app.run(debug=True)