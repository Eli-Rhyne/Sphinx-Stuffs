package Configuration;


import com.sun.speech.freetts.*;


class VoiceEx {
	 
    private String name = "kevin16";
    private Voice systemVoice;
    
    public VoiceEx() {
        Voice v[] = VoiceManager.getInstance().getVoices();
        for (int i = 0; i < v.length; i++) {
            System.err.println(v[i].getName());
        }
        this.systemVoice = VoiceManager.getInstance().getVoice(this.name);
        this.systemVoice.allocate();
    }
 
    public void say(String[] thingsToSay) {
        for (int i = 0; i < thingsToSay.length; i++) {
            this.say(thingsToSay[i]);
        }
    }
 
    public void say(String thingToSay) {
        this.systemVoice.setPitch(100.0f);
        this.systemVoice.setRate(150.0f);
        this.systemVoice.speak(thingToSay);
    }
 
    public void dispose() {
        this.systemVoice.deallocate();
    }
}