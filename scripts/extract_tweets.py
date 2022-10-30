import tweepy,json
access_token = "1485395819700404229-NZEkwdqLsfUXlAXxgSS18o0Ne3ZtIv"
access_token_secret = "l1TQjKDz6fmQS8tQ2985vYvimYIEme3l6XZx8zFU8LSIT"
consumer_key = "J6t9sNlYpl4jf7UBwpQlYPqcE"
consumer_secret = "k5OmdaoEMwX41WPuoYnooTZ7yOYzHAnHXyXhpeecYKuRd6eZ0E"

auth= tweepy.OAuthHandler(consumer_key,consumer_secret)
auth.set_access_token(access_token,access_token_secret)

api = tweepy.API(auth, wait_on_rate_limit=True, wait_on_rate_limit_notify=True, compression=True)
tweet_list=[]

# class MyStreamListener(tweepy.Stream):  tweepy.StreamListener
class MyStreamListener(tweepy.StreamListener):
    def __init__(self,api=None):
        super(MyStreamListener,self).__init__()
        self.num_tweets=0
        self.file=open("tweet.txt","w+")
    def on_status(self,status):
        tweet=status.text
        print(tweet)
        self.file.write(json.dumps(tweet)+ '\n')
        tweet_list.append(status)
        self.num_tweets+=1
        if self.num_tweets<2:
            return True
        else:
            return False
        self.file.close()


#create streaming object and authenticate
# l = MyStreamListener()
# stream = tweepy.Stream(auth, MyStreamListener())
# l = MyStreamListener(stream)
# auth,MyStreamListener()

myStreamListener = MyStreamListener()
myStream = tweepy.Stream(auth = api.auth, listener=myStreamListener)
#this line filters twiiter streams to capture data by keywords
myStream.filter(track=['depression', 'sadness', 'fatigue', 'loneliness', 'loss of interest',
'low energy', 'low concentration'])


# tweets_data_path='tweet.txt'
# tweets_data=[]
# tweets_file=open(tweets_data_path,"r")
# #read in tweets and store on list
# for line in tweets_file:
#     tweet=json.loads(line)
#     tweets_data.append(tweet)

# tweets_file.close()
# print(tweets_data[0])
