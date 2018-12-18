package com.rarchives.ripme.tst.ripper.rippers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.rarchives.ripme.ripper.rippers.ViewcomicRipper;

public class ViewcomicRipperTest extends RippersTest {
    public void testViewcomicRipper() throws IOException {
        ViewcomicRipper ripper = new ViewcomicRipper(new URL("https://view-comic.com/batman-no-mans-land-vol-1/"));
        testRipper(ripper);
    }

    public void testGID() throws IOException {
        URL goodUrl = new URL("https://view-comic.com/batman-no-mans-land-vol-1/");
        URL badURl = new URL("https://view-comic.com/#@batman-no-mans-land-vol-1/");
        ViewcomicRipper ripper = new ViewcomicRipper(goodUrl);
        assertEquals("batman-no-mans-land-vol-1", ripper.getGID(goodUrl));
        try {
            ripper.getGID(badURl);
            fail("Fail in ViewComicTest "+ ripper.getGID(badURl));
        }catch (MalformedURLException e){
        }
    }

    public void getAlbumTitleTest() throws IOException {
        URL goodUrl = new URL("https://view-comic.com/batman-no-mans-land-vol-1/");
        ViewcomicRipper ripper = new ViewcomicRipper(goodUrl);
        assertEquals("view-comic_Batman - No Man’s Land vol 1 2018", ripper.getAlbumTitle(goodUrl));
    }

}