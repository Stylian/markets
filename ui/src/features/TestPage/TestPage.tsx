import React, {Component} from "react";
import styles from './TestPage.module.css';

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
        fetch("/api/tests/")
            .then(res => res.json())
            .then(
                (result) => {
                    this.setState(state => {
                        return {
                            ...state,
                            isLoaded: true,
                            tests: result,
                        }
                    });
                },
                (error) => {
                    this.setState(state => {
                        return {
                            ...state,
                            isLoaded: false,
                            error
                        }
                    });
                }
            );
    }

    postTest = (event: any) => {
        fetch("/api/tests/", {
            method: 'POST',
            headers: {'Content-Type': 'application/json'}
        })
            .then(res => res.json())
            .then(
                (result) => {
                    this.setState(state => {
                        return {
                            ...state,
                            tests: [...state.tests, result],
                        }
                    });
                },
                (error) => {
                    this.setState(state => {
                        return {
                            ...state,
                            isLoaded: false,
                            error
                        }
                    });
                }
            );
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
    