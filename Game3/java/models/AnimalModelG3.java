package models;

import java.awt.Rectangle;
import java.io.Serializable;
import java.util.HashMap;
import javax.swing.JComponent;
import Enums.Frames;



/**
 * @author Andrew
 *
 */
public class AnimalModelG3 extends AnimalModelCommon implements Serializable {
	private int graphicOnDeck;
	private int height;
	private int width;
	private int speedX;
	private int speedY;
	private boolean boundHit;
	private boolean restrictedMovement;
	private boolean wallHit = false;
	private boolean waveHit = false;
	private Pair beachLocation = new Pair(0,0);
	private HashMap<Frames, JComponent> frames;
	private int FrameHeight; //may be deleted
	private int FrameWidth; // may be deleted

	/**
	 * Constructor to initialize the animal. Sets default dimensions 
	 * and loads in animation map for the animal.
	 */
	public AnimalModelG3() {
		this.setHeight(60);
		this.setWidth(60);
		boundHit = false;
		restrictedMovement = false;
	
	}
	
	/**
	 * Getter for the image representing the current state of the animal.
	 * @return the current image representing the animal which will be painted on the screen
	 */
	public int getGraphicOnDeck() {
		return graphicOnDeck;
	}

	/**
	 * Setter for the image representing the current state of the animal.
	 * @param graphicOnDeck the current image representing the animal which will be painted on the screen
	 */
	public void setGraphicOnDeck(int graphicOnDeck) {
		this.graphicOnDeck = graphicOnDeck;
	}

	/**
	 * Returns the bounds of the animal for collision purposes
	 * @return Rectangle object representing the bounds and position of the animal
	 */
	public Rectangle getBounds() {
		return (new Rectangle(this.getLocX(),this.getLocY(),this.getWidth(),this.getHeight()));
	}
	
	
	/**
	 * Resets the position of animal. Used primarily in the tutorial.
	 */
	public void resetPos() {
		this.setLocX(250);
		this.setLocY(250);
		this.setSpeedX(0);
		this.setSpeedY(0);
	}

	/**
	 * Getter for height dimension of animal.
	 * @return height height dimension of animal
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * Set the height dimension of the animal.
	 * @param height height dimension of animal
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * Getter for the width dimension of the animal.
	 * @return int, representing the width of the animal visually
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Setter for the width dimension of the animal.
	 * @param width int, representing the width of the animal visually
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Getter for the horizontal speed of the animal.
	 * @return int, representing animal movement in the horizontal direction
	 */
	public int getSpeedX() {
		return speedX;
	}

	/**
	 * Setter for the horizontal speed of the animal.
	 * @param speed int, representing the animal movement in the horizontal direction
	 */
	public void setSpeedX(int speed) {
		this.speedX = speed;
	}
	
	/**
	 * Getter for the vertical speed of the animal.
	 * @return int, representing the animal movement in the vertical direction
	 */
	public int getSpeedY() {
		return speedY;
	}

	/**
	 * Sets the vertical speed of the animal.
	 * @param speed int, representing the animal movement in the vertical direction
	 */
	public void setSpeedY(int speed) {
		this.speedY = speed;
	}
	

	/**
	 * Getter that returns whether or not the animal it on contact with the side of the frame.
	 * @return boundHit ,boolean true if animal hit the side of the frame. False otherwise.
	 */
	public boolean isBoundHit() {
		return boundHit;
	}

	/**
	 * Setter to set the boundary collision state of the animal.
	 * @param boundHit ,boolean true if animal hit the side of the frame. False otherwise.
	 */
	public void setBoundHit(boolean boundHit) {
		this.boundHit = boundHit;
	}

	
	/**
	 * Getter for the pair of coordinates that represents the next tile the animal
	 * will be on with respect to the 7x7 positionGrid.
	 * @return Pair, a pair of coordinates x,y
	 */
	public Pair getPotentialMove() {
		return beachLocation;
	}
	
	
	/**
	 * Getter for the HashMap containing the panels inside of the game frame. Used primarily to
	 * set movement and boundary conditions of animal relative to the size of the panel
	 * in which it is located. This is useful for the size of the panel is dependent
	 * on the size of the screen.
	 * @return frames , a HashMap containing the frame components
	 */
	public HashMap<Frames, JComponent> getFrames() {
		return frames;
	}

	/**
	 * Setter for the HashMap containing the panels inside of the game frame.
	 * @param frames , a HashMap containing the frame components.
	 */
	public void setFrames(HashMap<Frames, JComponent> frames) {
		this.frames = frames;
	}

	/**
	 * Getter to determine if the animal is in contact with the wall
	 * @return wallHit ,boolean that determines if animal is in contact with a wall 
	 */
	public boolean isWallHit() {
		return wallHit;
	}

	/**
	 * Setter used to declare whether animal is in contact with a wall.
	 * @param b , a boolean that determines if animal is in contact with a wall
	 */
	public void setWallHit(boolean b) {
		wallHit = b;
	}
	
	/**
	 * Getter to determine if the movement of the animal is restricted. This is
	 * used in the tutorial.
	 * @return restrictedMovement , a boolean that determines if the movement of the animal is restricted
	 */
	public boolean isRestrictedMovement() {
		return restrictedMovement;
	}

	/**
	 * Setter to declare whether the movement of the animal is restricted.
	 * @param restrictedMovement ,a boolean that determines if the movement of the animal is restricted
	 */
	public void setRestrictedMovement(boolean restrictedMovement) {
		this.restrictedMovement = restrictedMovement;
	}

	/**
	 * Getter that determines if an animal is in contact with a wave.
	 * @return waveHit , a boolean that determines if the animal is in contact with a wave
	 */
	public boolean isWaveHit() {
		return waveHit;
	}

	/**
	 * Setter that declares if the animal is in contact with a wave.
	 * @param waveHit , a boolean that determines if the animal is in contact with a wave
	 */
	public void setWaveHit(boolean waveHit) {
		this.waveHit = waveHit;
	}

	
	/**
	 * Returns the location of the animal in terms of its placement on the 7x7 positionGrid.
	 * @return beachLocation Pair instance
	 */
	public Pair getBeachLocation() {
		return beachLocation;
	}

	/**
	 * Setter that stores a Pair of coordinates that indicate the location of theb animal
	 * in terms of its placement on the 7x7 positionGrid
	 * @param beachLocation Pair instance
	 */
	public void setBeachLocation(Pair beachLocation) {
		this.beachLocation = beachLocation;
	}
}