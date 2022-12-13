package Utils;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author haoireal
 */
public class XImage {
	public static Image getAppIcon(){
		URL url = XImage.class.getResource("/icon/Sale (2).png");
		return new ImageIcon(url).getImage();
	}
	public static void save(File src) {
	    File dst = new File("logos", src.getName());
	    if (!dst.getParentFile().exists())
	      dst.getParentFile().mkdirs(); 
	    try {
	      Path from = Paths.get(src.getAbsolutePath(), new String[0]);
	      Path to = Paths.get(dst.getAbsolutePath(), new String[0]);
	      Files.copy(from, to, new CopyOption[] { StandardCopyOption.REPLACE_EXISTING });
	    } catch (Exception ex) {
	      throw new RuntimeException(ex);
	    } 
	  }
	  
	  public static ImageIcon read(String fileName) {
	    File path = new File("logos", fileName);
	    return new ImageIcon(path.getAbsolutePath());
	  }
}
