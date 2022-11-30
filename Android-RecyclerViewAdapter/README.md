# Android-RecyclerViewAdapter
_An example illustrating a RecyclerView which has different views, similar to the one in the Youtube app._

`RecyclerView` is a great way of displaying a scrolling list of elements for a large data set. Most recyclerview only has one type of view/element. This article will show how to programmatically implement a recyclerview with different views in it.

_This app also implements a Bottom Navigation bar with fragments, though that is not the focus here._

#### Disclaimer
This is not an actual functioning Youtube app clone.
<br>

<img src="https://img.shields.io/badge/minSdkVersion-21-red.svg?style=true" alt="minSdkVersion 21" data-canonical-src="https://img.shields.io/badge/minSdkVersion-24-red.svg?style=true" style="max-width:100%;"> <img src=https://img.shields.io/badge/compileSdkVersion-28-brightgreen.svg alt="compileSdkVersion 28" data-canonical-src="https://img.shields.io/badge/compileSdkVersion-27-yellow.svg?style=true" style="max-width:100%;">

## RecyclerView In Action
![ezgif com-resize](https://user-images.githubusercontent.com/39665412/50394068-c51c5280-0795-11e9-8e98-a6d8536f21e1.gif)

## Tutorial
### Layout
In the activity/fragment layout, have a `CoordinatorLayout` as the root layout. Add the attribute `app:layout_behavior` to have the recyclerview scroll below the toolbar.
```xml
<android.support.v7.widget.RecyclerView
        android:id="@+id/library_recyclerView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layout_behavior="@string/appbar_scrolling_view_behavior" />
```

Create two seperate layout files for the two different views in the recyclerview.
1. [recyclerview_item_header.xml](https://github.com/wRorsjakz/Android-RecyclerViewAdapter/blob/master/app/src/main/res/layout/recyclerview_item_header.xml) - layout for the first item in the recyclerview
2. [recyclerview_item_video.xml](https://github.com/wRorsjakz/Android-RecyclerViewAdapter/blob/master/app/src/main/res/layout/recyclerview_item_video.xml) - layout for the other items below the first layout

### Java code
In the [recyclerview adapter](https://github.com/wRorsjakz/Android-RecyclerViewAdapter/blob/master/app/src/main/java/com/example/user/youtubelibrarypageclone/LibraryFragmentRecyclerViewAdapter.java), create two seperate `ViewHolder` for the two different layouts which extends from `RecyclerView.ViewHolder`. Initialise widgets in the specific view in the viewholder as well. 
```java
public class NameOfViewHolder extends RecyclerView.ViewHolder {
        private TextView title;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialise your widgets here
            title = itemView.findViewById(R.id.recyclerview_item_header_title);

            // Attach onClickListener here as well if you need
            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // Do something
                }
        }
```

Override `getItemViewType()`, which returns an `int` representing the view type at a position. By default, it returns 0 when there is only a single view type in the adapter. But since we have two view types, we need to return different values, in order for the adapter to inflate the correct view for the specific position.

In order to have the first element of the recyclerview be one view type, and the other elements be another:
```java
private static final int headerItemType = 0;
private static final int videoItemType = 1;

 @Override
    public int getItemViewType(int position) {
        // If header item, return 0
        if (position == 0) {
            return headerItemType;
        } else {
            return videoItemType;
        }
    }
```
In `onCreateViewHolder()`, inflate the view depending on the view type.
Note that `int i` is the view type and not the position of element in the adapter, and that you need to return a default viewholder.
```java
public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        switch (i) {
            case headerItemType:
                view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item_header,viewGroup,false);
                return new HeaderViewHolder(view);
            case videoItemType:
                view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item_video,viewGroup,false);
                return new VideoViewHolder(view);
        }
        // Default case
        view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item_header,viewGroup,false);
        return new HeaderViewHolder(view);
```
The same thing applies to `onBindViewHolder()` where you append/show whatever data you need in the recyclerview. Again, `int i` is the viewtype. Use `getItemViewType()` to get that value.
```java
@Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()){
            case headerItemType:
                HeaderViewHolder headerViewHolder = (HeaderViewHolder)viewHolder;
                // Bind whatever data for headerViewHolder here
                break;
            case videoItemType:
                VideoViewHolder videoViewHolder = (VideoViewHolder)viewHolder;
                //Bind whatever data for videoViewHolder here
        }
    }
```
In the activity/fragment, instantiate the adapter, pass the date you need to display to it and attach it to the recyclerview using `setAdapter()`.
```java
recyclerView = view.findViewById(R.id.library_recyclerView);
adapter = new LibraryFragmentRecyclerViewAdapter(getContext(),data);
recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
recyclerView.setHasFixedSize(true);
recyclerView.setAdapter(adapter);
```

## Dependencies/Built With
- [Design Support Library](https://developer.android.com/reference/android/support/design/package-summary) - The Design package provides APIs to support adding material design components and patterns to your apps
- [RecyclerView](https://developer.android.com/reference/android/support/v7/widget/RecyclerView) - A flexible view for providing a limited window into a large data set.
- [BottomNavigationViewEx](https://github.com/ittianyu/BottomNavigationViewEx) - An android lib for enhancing BottomNavigationView.

In `build.gradle(Project:My-app)`:
```java
 allprojects {   
    repositories {
        ...
        maven { url "https://jitpack.io" }
        maven { url "https://maven.google.com" }
    }
}
```
In `build.gradle(Module:app)`:
```java
dependencies{
    implementation 'com.android.support:design:28.0.0'
    implementation 'com.android.support:recyclerview-v7:28.0.0'
    implementation 'com.github.ittianyu:BottomNavigationViewEx:2.0.2'
}
```
## License
```tex
MIT License

Copyright (c) 2018 Nicholas Gan

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```