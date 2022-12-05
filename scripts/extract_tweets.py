import tweepy,json
import pandas as pd
import sys
def get_tweets(hashtags, tweet_text):

    print(hashtags)
    # search_results = api.search_tweets(q=ha  # shtags, count=200)
    tweets = tweepy.Cursor(api.search,
                                q = hashtags, lang = "en",
                               # 200 is the max imum allowed count
                               # count=500,
                               include_rts = False,
                               # Necessary to keep full_text
                               # otherwise only the first 140 words are extracted
                              tweet_mode = "extended"
                               ).items(1000)
    # print(tweet.id_str, tweet.created_at, tweet.favorite_count, tweet.retweet_count, tweet.full_text.encode("utf-8").decode("utf-8"))
    col_tweets = [[tweet.created_at, tweet.full_text.encode("utf-8").decode("utf-8"),tweet.entities['hashtags']] for tweet in tweets]
    # print(col_tweets)
    df = pd.DataFrame(col_tweets, columns=["created_at", "tweet_text", "hashtags"])
    tweet_text_ = pd.concat([tweet_text, df], ignore_index=True)

    #save to csv file
    tweet_text_.to_csv("Tweets.csv", index=False)
    print("Total tweets: ", tweet_text_.shape)
    print("Collected tweets!!")

if __name__ == '__main__':
    access_token = ""
    access_token_secret = ""
    consumer_key = ""
    consumer_secret = ""

    auth = tweepy.OAuthHandler(consumer_key, consumer_secret)
    auth.set_access_token(access_token, access_token_secret)

    api = tweepy.API(auth, wait_on_rate_limit=True, wait_on_rate_limit_notify=True, compression=True)

    try:
        tweet_text = pd.read_csv("Tweets.csv")
        # tweet_text = pd.DataFrame(columns=["created_at", "tweet_text", "hashtags"])

    except:
        tweet_text = pd.DataFrame(columns=["created_at", "tweet_text", "hashtags"])


    #need to take hashtags as arguments
    hashtags = sys.argv[1:]
    print(hashtags)
    for h in hashtags:
        get_tweets("#"+h, tweet_text)
