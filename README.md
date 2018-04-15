SWEng video player library for JavaFX. Uses the mp4 file format. 

# Adding the library
Place the files contained in the src directory (except the main) in your JavaFX project src directory.

# Example usage
There is example code on how to use the library in the `Main.java`. 

To use the code with the video file being in the current working directory, create a `VideoPlayer` object with the constructor:
```java
VideoPlayer video = new VideoPlayer(scene, "filename");
```

If the video file is in a different directory, use the constructor:
```java
VideoPlayer video = new VideoPlayer(scene, "filename", "filepath");
```

Then you can call the `getPane()` method to return the video player pane and use it to add to your own pane. In the example code for a BorderPane:

```java
root.setCenter(video.getPane());
```

And enabling the provided video controls with this method:

```java
video.enableVideoControls();
```
# Example video files
Some example mp4 files can be found here:
[Videos link](https://drive.google.com/drive/folders/1seT5mkx0hkaTat670wtL5yoBzKa9GhWv?usp=sharing)

# Creating your own video controller
The VideoPlayer class contains methods which return the Media, MediaPlayer, and MediaView objects. The provided VideoController takes the MediaView, MediaPlayer, and the parent pane (in this case a VBox) of the VideoPlayer; these objects are required to program the video player listeners and, for example, add buttons below the video player. 

I'd recommend extending the VideoController class or creating your own class that take the objects above.

