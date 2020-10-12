package net.sigmainfo.lf.automation.common;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.springframework.beans.factory.annotation.Autowired;

import net.sigmainfo.lf.automation.api.constant.ApiParam;
import net.sigmainfo.lf.automation.common.SpecializedScreenRecorder;

/**
 * Created by : Rengarajan.m on 06-12-2017. Test class : Recorder.java Description
 * : This class used for recording the test case
 */
public class Recorder {

	@Autowired
	ApiParam apiParam;
	public SpecializedScreenRecorder screenRecorder;

	public void startRecording(String FileName) {
		// TODO Auto-generated method stub
		File file = new File("./Videos");
		
		java.awt.Dimension screenSize = Toolkit.getDefaultToolkit()
				.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;

		Rectangle captureSize = new Rectangle(0, 0, width, height);

		GraphicsConfiguration gc = GraphicsEnvironment
				.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();

		try {

			this.screenRecorder = new SpecializedScreenRecorder(gc,
					captureSize, new Format(MediaTypeKey, MediaType.FILE,
							MimeTypeKey, MIME_AVI), new Format(MediaTypeKey,
							MediaType.VIDEO, EncodingKey,
							ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
							CompressorNameKey,
							ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey,
							24, FrameRateKey, Rational.valueOf(15), QualityKey,
							1.0f, KeyFrameIntervalKey, 15 * 60), new Format(
							MediaTypeKey, MediaType.VIDEO, EncodingKey,
							"black", FrameRateKey, Rational.valueOf(30)), null,
					file, FileName);

			this.screenRecorder.start();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void stopRecording() {
		try {
			this.screenRecorder.stop();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
