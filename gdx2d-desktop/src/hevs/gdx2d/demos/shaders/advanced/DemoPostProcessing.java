package hevs.gdx2d.demos.shaders.advanced;

import hevs.gdx2d.components.bitmaps.BitmapImage;
import hevs.gdx2d.lib.GdxGraphics;
import hevs.gdx2d.lib.PortableApplication;
import hevs.gdx2d.lib.utils.Logger;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;

/**
 * Demonstrates how to use a shader to postprocess
 * an image generated by the library. The idea is to generate
 * everything you want in a backbuffer (~ a texture)
 * then copy it to the active buffer and then apply a
 * shader to which the texture data is the rendered image.
 * @author Pierre-André Mudry
 * @version 1.0
 */
public class DemoPostProcessing extends PortableApplication{

	public DemoPostProcessing(boolean onAndroid) {
		super(onAndroid);
	}
	
	@Override
	public void onInit() {	
		this.setTitle("Postprocessing with a shader, mui 2013");
		imageAndroid = new BitmapImage("data/images/Android_PI_48x48.png");
		imageBackground = new BitmapImage("data/images/back1_512.png");
		fbo = new FrameBuffer(Format.RGBA8888, this.getWindowWidth(), this.getWindowHeight(), false);
		Logger.log("Click to enable/disable shader");
	}
	
	float time = 0;
	boolean shaderEnabled = true;

	// Used for off screen rendering
	FrameBuffer fbo;
	
	// Standard images used for drawing
	BitmapImage imageAndroid, imageBackground;
	
	@Override
	public void onGraphicRender(GdxGraphics g) {
		if(g.shaderRenderer == null){
			g.setShader("data/shader/advanced/postprocessing.fp");
		}

		// Draw some stuff to an offscreen buffer, using normal
		// gdx2d primitives
		fbo.begin();
			g.clear();
			g.drawPicture(256, 256, imageBackground);
			g.drawTransformedPicture(256, 256, time*100, 1, imageAndroid);
			g.drawFPS();		
			g.drawSchoolLogo();
		fbo.end();
		
		// Copy the offscreen buffer to the displayed bufer
		g.shaderRenderer.setTexture(fbo.getColorBufferTexture(), 0);
		g.shaderRenderer.setUniform("enabled", shaderEnabled);
		
		time+= Gdx.graphics.getDeltaTime();			
		g.drawShader(time);		
	}
	
	public void onClick(int x, int y, int button) {
		super.onClick(x, y, button);
		shaderEnabled = !shaderEnabled;
	}
	
	public static void main(String args[]){
		new DemoPostProcessing(false);
	}
}
