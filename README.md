# Project 2 - *NYTimesSearch App*

**NYTimesSearch App** is an android app that allows a user to search for articles on web using simple filters. The app utilizes [New York Times Search API](http://developer.nytimes.com/docs/read/article_search_api_v2).

Time spent: **10** hours spent in total

## User Stories

The following **required** functionality is completed:

* [V] User can **search for news article** by specifying a query and launching a search. Search displays a grid of image results from the New York Times Search API.
* [V] User can click on "settings" which allows selection of **advanced search options** to filter results
* [partly ] User can configure advanced search filters such as:
  * [partly] Begin Date (using a date picker)
  * [V] News desk values (Arts, Fashion & Style, Sports)
  * [V] Sort order (oldest or newest)
* [partly] Subsequent searches have any filters applied to the search results
* [V] User can tap on any article in results to view the contents in an embedded browser.
* [V] User can **scroll down to see more articles**. The maximum number of articles is limited by the API search.

The following **optional** features are implemented:

* [V] Implements robust error handling, [check if internet is available](http://guides.codepath.com/android/Sending-and-Managing-Network-Requests#checking-for-network-connectivity), handle error cases, network failures
* [V] Improved the user interface and experiment with image assets and/or styling and coloring

The following **bonus** features are implemented:

* [V] Use Parcelable instead of Serializable using the popular [Parceler library](http://guides.codepath.com/android/Using-Parceler).

The following **additional** features are implemented:

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='http://imgur.com/3Ae0BT7.gif' title='Video Walkthrough' width='500' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

Describe any challenges encountered while building the app.

## Open-source libraries used

- [Android Async HTTP](https://github.com/loopj/android-async-http) - Simple asynchronous HTTP requests with JSON parsing
- [Picasso](http://square.github.io/picasso/) - Image loading and caching library for Android

## License

    Copyright [yyyy] [name of copyright owner]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
