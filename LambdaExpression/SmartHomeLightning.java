class SmartHomeLighting {
    public static void main(String[] args) {
        Runnable motionTrigger = () -> System.out.println("Lights ON with motion sensor");
        Runnable timeTrigger = () -> System.out.println("Lights DIM at night");
        Runnable voiceTrigger = () -> System.out.println("Lights OFF with voice command");

        motionTrigger.run();
        timeTrigger.run();
        voiceTrigger.run();
    }
}
