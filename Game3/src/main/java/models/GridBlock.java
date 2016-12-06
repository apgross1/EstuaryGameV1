package models;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class GridBlock {
	private Pair location;
	private GabionPUModel gabPU = new GabionPUModel();
	private ConcretePUModel concrPU = new ConcretePUModel();
	private WaterModel water;
	private boolean vacant;
	private int height;
	private int width;
	private BeachModel beach;
	private Pair viewLocation = new Pair(0,0);
	private BufferedImage sandGraphic;
	
	public GridBlock(BeachModel b) {
		water = new WaterModel();
		gabPU.setIsActive(false);
		concrPU.setActive(false);
		height = 200;
		width = 200;
		vacant = true;
		beach = b;
	}
	
	public GridBlock(Pair loc, BeachModel b) {
		water = new WaterModel();

		gabPU = new GabionPUModel();
		gabPU.setIsActive(false);
		beach = b;
		concrPU = new ConcretePUModel();
		concrPU.setActive(false);
		location = loc;
		this.setViewLocation(location);
		height = 200;
		width = 200;
		vacant = true;
	}
	
	public GridBlock(Pair loc, BeachModel b, String Test) {
		gabPU = new GabionPUModel();
		gabPU.setIsActive(false);
		beach = b;
		concrPU = new ConcretePUModel();
		concrPU.setActive(false);
		location = loc;
		this.setViewLocation(location);
		height = 200;
		width = 200;
		vacant = true;
	}
	

	public GridBlock(ConcretePUModel powerUp, Pair loc) {
		water = new WaterModel();

		gabPU.setIsActive(false);
		concrPU.setActive(false);
		powerUp.setLocation(loc,"Game");
		this.setConcrPU(powerUp);
		this.location = loc;
		this.setViewLocation(location);
		this.setVacant(false);
	}
	public GridBlock(GabionPUModel powerUp, Pair loc) {
		water = new WaterModel();

		gabPU.setIsActive(false);
		concrPU.setActive(false);
		powerUp.setLocation(loc);
		this.setGabPU(powerUp);
		this.location = loc;
		this.setViewLocation(location);
		this.setVacant(false);
	}
	
	public void setWater(WaterModel water, Pair loc, String test) {
		if(test == "test"){
			gabPU.setIsActive(false);
			concrPU.setActive(false);
			water.setLocation(loc);
			this.water = water;
			this.water.setActive(true);
			//this.location = loc;
			this.setVacant(false);
			
			beach.getPositionGrid()[loc.getY()][loc.getX()] = 2;
			System.out.println("Value on grid at (" + loc.getX() + "," + loc.getY() + "): " + beach.getPositionGrid()[loc.getY()][loc.getX()]);
			
		}
		else{
			gabPU.setIsActive(false);
			concrPU.setActive(false);
			water.setLocation(loc);
			this.water = water;
			this.water.setActive(true);
			// this.location = loc;
			this.setVacant(false);

			beach.getPositionGrid()[loc.getY()][loc.getX()] = 2;
			water.addPics();
			System.out.println("Value on grid at (" + loc.getX() + "," + loc.getY() + "): " + beach.getPositionGrid()[loc.getY()][loc.getX()]);
		}
	}
	
	
	public void addPic() {
		try {
			sandGraphic = ImageIO.read(new File("./Images/Game3/tile_sand_center.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Pair getLocation() {
		return location;
	}

	public void setLocation(Pair location) {
		this.location = location;
	}

	public GabionPUModel getGabPU() {
		return gabPU;
	}

	public void setGabPU(GabionPUModel gabPU) {
		concrPU.setActive(false);
		water.setActive(false);
		gabPU.setIsActive(true);
		this.gabPU = gabPU;
		this.setVacant(false);
	}

	public ConcretePUModel getConcrPU() {
		return concrPU;
	}

	public void setConcrPU(ConcretePUModel concrPU) {
		concrPU.setActive(true);
		this.concrPU = concrPU;
		this.gabPU.setIsActive(false);
		this.water.setActive(false);
		
		this.setVacant(false);
	}

	public boolean isVacant() {
		return vacant;
	}

	public void setVacant(boolean vacant) {
		this.vacant = vacant;
		if(vacant) {
			this.water.setActive(false);
			this.gabPU.setIsActive(false);
			this.concrPU.setActive(false);
		}
	}
	
	public Rectangle getBounds() {
		return (new Rectangle(this.getViewLocation().getX(),this.getViewLocation().getY(),this.getWidth(),this.getHeight()));
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public WaterModel getWater() {
		return water;
	}
	
	public Pair getViewLocation() {
		return viewLocation;
	}
	public void setViewLocation(Pair viewLocation) {
		this.viewLocation = viewLocation;
	}

	public BufferedImage getSandGraphic() {
		return sandGraphic;
	}

	public void setSandGraphic(BufferedImage sandGraphic) {
		this.sandGraphic = sandGraphic;
	}

	
}
