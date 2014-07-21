package com.example.twitterapp.dto;

import java.util.List;

public class SearchTweetResponse extends Response {
	private List<Tweet> tweetList;

	public List<Tweet> getTweetList() {return tweetList;}
	public void setTweetList(List<Tweet> tweetList) {this.tweetList = tweetList;}
}
