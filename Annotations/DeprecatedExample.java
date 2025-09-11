class LegacyAPI {

    @Deprecated // Marks old feature
    public void oldFeature() {
        System.out.println("⚠️ oldFeature() is deprecated. Please use newFeature()");
    }

    public void newFeature() {
        System.out.println("✅ newFeature() is running smoothly!");
    }
}

public class DeprecatedExample {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature(); // Compiler will show warning
        api.newFeature();
    }
}
