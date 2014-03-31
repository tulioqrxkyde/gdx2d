package hevs.gdx2d.components.colors;

import com.badlogic.gdx.graphics.Color;

/**
 * Nice color palettes for drawing nice stuff. Each element
 * of the palette can be used as a {@link Color} with the proper conversion
 * (for instance by using {@link ColorUtils}). Each color of
 * each palette has a nice effect with the other colors of the same palette
 * 
 * @author Pierre-André Mudry
 */
public class Palette {
	/**
	 * A nice set of pastel colors
	 */
	public static final Color pastel1[] = {
		ColorUtils.intToColor(0xB1654B),
		ColorUtils.intToColor(0xF79273),
		ColorUtils.intToColor(0xFDC08E),
		ColorUtils.intToColor(0xFFF6B9),
		ColorUtils.intToColor(0x99D1B7)	
	};
	
	/**
	 * Another set of nice pastel colors
	 */
	public static final Color pastel2[] = {
		ColorUtils.intToColor(0xffffff),
		ColorUtils.intToColor(0xe3e3e3),
		ColorUtils.intToColor(0xded6ea),
		ColorUtils.intToColor(0xfebed7),
		ColorUtils.intToColor(0xebfebe),
		ColorUtils.intToColor(0xbecafe),
		ColorUtils.intToColor(0x8c9ad4),
		ColorUtils.intToColor(0xfeeabe)	
	};
}
