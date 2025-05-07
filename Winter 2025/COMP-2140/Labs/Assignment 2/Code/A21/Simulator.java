public class Simulator {
    public static boolean run(DFA dfa, String input) {
        // Initialize the current state to the DFA's start state
        String currentState = dfa.startState;
        // Loop through each character in the input string
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            // Move to the next state based on the current character
            String transitionKey = currentState + "_" + currentChar;
            if (dfa.transitions.containsKey(transitionKey)) {
                currentState = dfa.transitions.get(transitionKey); // Move to the next state
            } else {
                return false; // If there's no valid transition, reject the input
            }
        }
        // Check if the final state is an accepting state
        if (dfa.finalStates.contains(currentState)) {
            return true; // Accept the input
        }
        return false; // Reject the input
    
        }
}
