package java.game.maps;

import java.game.*;
import java.util.resource.*;
import java.util.*;
import java.render.*;
import java.sound.*;

public class test_MT extends MapType
{
	final static public SfxRef citynoise  = new SfxRef("maps/test/sfx/birds.wav");


	int			sfx1;
Vector3 obj_pos =  new Vector3(-803.751, 85.036, 2188.390 );

	
	public test_MT( int id )
	{
		this();
	}

	public test_MT() 
	{
		map = new GroundRef( maps.test:0x0001r );
		name = "test";		
		suntype = new RenderRef( maps.test:0x000Ar );
		index = -1;
		preview[0]=maps.test:0x002cr;
		preview[1]=maps.test:0x002cr;

		blimp_pos = new Vector3(542.000, 209.000, 337.000 );

		tracks = new MapTrack[2];
		int TI = 0;

		tracks[TI] = new MapTrack();
		tracks[TI].spline = "maps/test/test_Route_00.spl2";
		fillTrackData(TI);
		TI++;

		tracks[TI] = new MapTrack();
		tracks[TI].spline = "maps/test/test_Route_01.spl2";
		fillTrackData(TI);
		TI++;
	}

	public CheckPoint[] getCheckPoints( int mode )
	{
		switch( mode )
		{
			case 0: return Route_00_Data();
			case 1: return Route_01_Data();
		}
		return null;
	}

	public void prepareTrack(Track trk, int mode )
	{
		super.prepareTrack(trk, mode);
		map.setFog( 0x008d9092, 10.0, 6500.0 );

		map.setWater(-1.686, -500.0, 50.0);
		map.addWaterLimit(new Vector3(500.0, -500.0, -50.0), new Vector3(0.0, 0.0, -1.0));
		
		suntype.setLight( 0x00aeaeae, 0x00717171, 0x00202020, 0x00ffffff);//tamas+fog!!!!
		GfxEngine.setGlobalEnvmap( new ResourceRef( maps.test:0x0005r ));
		GfxEngine.setGlobalCubemap( new ResourceRef( maps.test:0x000Br ));
		GfxEngine.setShadowmap( "maps/test/shadowz.raw" );
		GfxEngine.setGlowThreshold( 1.5 );
		GfxEngine.setShadowColor( 0x00181500, 0x005b5b5b ); 

		suntype.setFlare( new ResourceRef(maps.test:0x0007r), 0xFFE552FF, 2.0, 4.0, 9, 9 )

		skydome = new RenderRef[7];
		GameLogic.setDirtType(1);

		System.setDirtLevel(0);
		customObjects = new Vector(32);
		banners = new Vector(32);


				customObjects.addElement( new GameRef( map, maps.objects:0x00000528r, "320.982, 31.781, 1432.490, 0.000, 0.000, 0.000", "buoy 43" ) );
			
		gates[01] = new GateInfo( new Vector3(-159.907, 12.258, 0.681),	new Vector3(-167.033, 12.202, 0.082));
	
		return gates;
	}

}
