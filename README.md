# PolyView
A custom view for creating polygons. Custom view takes attributes like no of sides, radius for area to in which view should be drawan & color for the view.

[![](https://jitpack.io/v/AB1209/PolyView.svg)](https://jitpack.io/#AB1209/PolyView)


![](images/PolyView.jpg)

## Getting Started
Add following line in your project's build.gradle file under allprojects > repositories 
```
 maven { url 'https://jitpack.io' }
 ```

In your app's build.gradle add in dependencies.

```
implementation 'com.github.AB1209:PolyView:v1.0.3'
```
 
## Usage
In your layout file you can add PolyView. 
``` 
<com.ab1209.polylib.view.PolyView
android:layout_width="wrap_content"
android:layout_height="wrap_content"
app:noOfSides="4"
app:radius="30dp"
app:color="@color/green"/>
 ```
In Java you use in following way
```
  PolyView polyView = new PolyView(this);
  polyView.setColor(getResources().getColor(R.color.colorAccent));
  polyView.setNoOfSides(3);
  polyView.setRadius(300);
```        
You can also use
```
changeShape(int noOfSides, float radius, int color)
``` 
to dynamically change the shape, size & color.


 😍 Happy Coding 😍
