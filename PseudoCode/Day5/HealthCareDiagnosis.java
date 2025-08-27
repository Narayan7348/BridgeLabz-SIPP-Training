/*// Step 1: Strategy Interface
interface DiagnosisStrategy {
    List<String> diagnose(List<String> symptoms);
}

// Step 2: Different strategies
class RuleBasedDiagnosis implements DiagnosisStrategy {
    List<String> diagnose(List<String> symptoms) {
        if(symptoms.contains("fever") && symptoms.contains("cough"))
            return ["Flu", "COVID-19"];
        return ["Unknown"];
    }
}

class AIBasedDiagnosis implements DiagnosisStrategy {
    List<String> diagnose(List<String> symptoms) {
        // Use ML model simulation
        if(symptoms.contains("headache") && symptoms.contains("dizziness"))
            return ["Migraine", "Vertigo"];
        return ["Unknown"];
    }
}

class ProbabilityBasedDiagnosis implements DiagnosisStrategy {
    List<String> diagnose(List<String> symptoms) {
        // Return top diseases based on probability calculation
        return ["DiseaseX (70%)", "DiseaseY (30%)"];
    }
}

// Step 3: Context
class DiagnosisContext {
    private DiagnosisStrategy strategy;

    void setStrategy(DiagnosisStrategy strategy) {
        this.strategy = strategy;
    }

    void executeDiagnosis(List<String> symptoms) {
        List<String> result = strategy.diagnose(symptoms);
        print("Possible Diagnosis: " + result);
    }
}

// Step 4: Demonstration
main() {
    DiagnosisContext context = new DiagnosisContext();

    // Case 1: General Medicine
    context.setStrategy(new RuleBasedDiagnosis());
    context.executeDiagnosis(["fever", "cough", "fatigue"]);

    // Case 2: Neurology
    context.setStrategy(new AIBasedDiagnosis());
    context.executeDiagnosis(["headache", "dizziness", "nausea"]);

    // Case 3: Adding a new algorithm tomorrow
    class GeneticPatternDiagnosis implements DiagnosisStrategy {
        List<String> diagnose(List<String> symptoms) {
            return ["Genetic Disorder Suspected"];
        }
    }
    context.setStrategy(new GeneticPatternDiagnosis());
    context.executeDiagnosis(["gene_mutation", "family_history"]);
}
*/
