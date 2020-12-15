import React, {Component} from "react";
import styles from './TestPage.module.css';
import {addTest, loadTests} from "./TestPageScripts";

type TestPageProps = {
    
}

type TestPageState = {
    isLoaded: boolean;
    tests: {
        counter: number;
        id: number;
        value: number;
    }[];
}

export class TestPage extends Component<TestPageProps, TestPageState> {

    constructor(props: TestPageProps) {
        super(props);

        this.state = {
            isLoaded: false,
            tests: [],
        };

    }

    componentDidMount() {
        loadTests(this);
    }

    postTest = (event: any) => {
        addTest(this);
    }
    
    render() {
        return this.state.isLoaded ? (
            <div className={styles.main}>
                {this.state.tests.map((test, k) => 
                    (<div key={k}>{test.counter}</div>))}
                <button
                    onClick={this.postTest}
                > Test </button>
            </div>
        ) : (null);
    }
    
}
    