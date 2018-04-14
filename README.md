SWEng video player library for JavaFX. Uses the mp4 file format. 

#Example usage
There is example code on how to use the library in the `Main.java`. 

To use the code, create a `VideoPlayer` object with the constructor below:
```java
VideoPlayer video = new VideoPlayer(scene, "filename");
``` 
You can call the `getPane()` method to return the video player pane and use it to add to your own pane. Like, in the example code for a BorderPane:

```java
root.setCenter(video.getPane());
```

#Methods
