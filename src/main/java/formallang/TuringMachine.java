package formallang;

import java.util.Map;
import java.util.Set;

public class TuringMachine {
    private final Set<State> states;
    private final Set<State> initialStates;
    private final Set<State> finalStates;
    private final Map<TransitionContext, Transition> transitionFunc;

    public TuringMachine(
        Set<State> states,
        Set<State> initialStates,
        Set<State> finalStates,
        Map<TransitionContext, Transition> transitionFunc
    ) {
        this.states = states;
        this.initialStates = initialStates;
        this.finalStates = finalStates;
        this.transitionFunc = transitionFunc;
    }

    public Set<State> getInitialStates() {
        return initialStates;
    }

    public Set<State> getFinalStates() {
        return finalStates;
    }

    public Set<State> getStates() {
        return states;
    }

    public Map<TransitionContext, Transition> getTransitionFunc() {
        return transitionFunc;
    }

    public static class State {
        private final String value;

        public State(String value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object other) {
            if (!(other instanceof State)) {
                return false;
            } else {
                return ((State) other).value.equals(this.value);
            }
        }

        public String getValue() {
            return value;
        }
    }

    public static class TransitionContext {
        private final State state;
        private final String tapeSym;

        public TransitionContext(State state, String tapeSym) {
            this.state = state;
            this.tapeSym = tapeSym;
        }

        public State getState() {
            return state;
        }

        public String getTapeSym() {
            return tapeSym;
        }
    }

    public static class Transition {
        public enum Direction {
            LEFT,
            RIGHT
        }

        private final TransitionContext contextTo;
        private final Direction direction;

        public Transition(TransitionContext contextTo, Direction direction) {
            this.contextTo = contextTo;
            this.direction = direction;
        }

        public TransitionContext getContextTo() {
            return contextTo;
        }

        public Direction getDirection() {
            return direction;
        }
    }
}