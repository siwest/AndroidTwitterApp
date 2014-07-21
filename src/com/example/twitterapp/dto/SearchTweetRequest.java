package com.example.twitterapp.dto;

public class SearchTweetRequest extends Request {
	private String searchString;

	public SearchTweetRequest() {
		super(Request.REQUEST_TYPE_SEARCH_TWEET);
	}
	
	public String getSearchString() {return searchString;}
	public void setSearchString(String searchString) {this.searchString = searchString;}
	
	public String toString(){
		return new StringBuffer()
			.append("SearchTweetRequest[")
			.append("requestType: " + requestType + "; ")
			.append("searchString: " + searchString + "; ")
			.append("]")
			.toString(); 
	}
	
}
