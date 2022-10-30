from flask import Flask, request
import pickle
import numpy as np
# import os
# print(os.getcwd())
app = Flask(__name__)
model = pickle.load(open('../Models/rf_model_corrected.pkl', 'rb'))


#Routing means mapping the URLs to a specific function
# that will handle the logic for that URL

@app.route("/predict", methods=['POST'])
def predict():  #to bind a function to a url
    input_ = np.array([[int(i) for i in request.get_json()]])
    pred = model.predict(input_)
    return pred

if __name__ == "__main__":
    app.run(debug=True)