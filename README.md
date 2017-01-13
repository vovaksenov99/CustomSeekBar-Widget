
# How To use?

This is custom seekBar for android project with step. 

![default](https://cloud.githubusercontent.com/assets/13554528/21932841/69d04fb8-d9c4-11e6-92f1-0b3418b6ba97.PNG)


## Java code
```java
    CustomSeekBar t =(CustomSeekBar)findViewById(R.id.durationview1);
		t.set_interval(new String[]{"step 1","step 2","step 3","step 4","step 5"});
		t.setPadding(100,10,100,0);
		t.setProgress(2);
```
## XmlCode
In xml file you need to declarate view. You can do it next way:

```xml
       <com.akscorp.TeamDay.CustomSeekBar
                        android:id="@+id/custom"
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content" />
```
