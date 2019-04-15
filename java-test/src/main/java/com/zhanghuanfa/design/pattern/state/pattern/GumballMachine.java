package com.zhanghuanfa.design.pattern.state.pattern;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhanghuanfa 2019-04-15 15:00
 */
public class GumballMachine {
    @Getter
    private State soldOutState;
    @Getter
    private State noQuarterState;
    @Getter
    private State hasQuarterState;
    @Getter
    private State soldState;
    @Getter
    private State winnerState;

    @Getter
    @Setter
    private State state = soldOutState;
    @Getter
    @Setter
    int count = 0;

    public GumballMachine(int count) {
        this.soldOutState = new SoldOutState(this);
        this.noQuarterState = new NoQuarterState(this);
        this.hasQuarterState = new HasQuarterState(this);
        this.soldState = new SoldState(this);
        this.winnerState = new WinnerState(this);
        this.count = count;
        if (count > 0) {
            this.state = noQuarterState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count = count - 1;
        }
    }
}
