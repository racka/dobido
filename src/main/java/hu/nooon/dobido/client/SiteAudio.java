package hu.nooon.dobido.client;

import com.allen_sauer.gwt.voices.client.Sound;
import com.allen_sauer.gwt.voices.client.SoundController;
import hu.nooon.dobido.client.resource.SiteClientBundle;

public class SiteAudio {


    private SoundController soundController;
    private Sound sound;

    public SiteAudio() {
        soundController = new SoundController();
        sound = soundController.createSound(Sound.MIME_TYPE_AUDIO_WAV_PCM,
                SiteClientBundle.INSTANCE.audio1().getSafeUri().asString());
        sound.setLooping(true);
    }

    public void start() {
        sound.play();
        sound.setVolume(50);
    }

    public void stop() {
        sound.stop();
    }



}
