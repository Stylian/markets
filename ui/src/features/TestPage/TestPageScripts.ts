import {TestPage} from "./TestPage";

export const loadTests = (page: TestPage) => {
    fetch("/api/tests/")
        .then(res => res.json())
        .then(
            (result) => {
                page.setState(state => {
                    return {
                        ...state,
                        isLoaded: true,
                        tests: result,
                    }
                });
            },
            (error) => {
                page.setState(state => {
                    return {
                        ...state,
                        isLoaded: false,
                        error
                    }
                });
            }
        );
}

export const addTest = (page: TestPage) => {
    fetch("/api/tests/", {
        method: 'POST',
        headers: {'Content-Type': 'application/json'}
    })
        .then(res => res.json())
        .then(
            (result) => {
                page.setState(state => {
                    return {
                        ...state,
                        tests: [...state.tests, result],
                    }
                });
            },
            (error) => {
                page.setState(state => {
                    return {
                        ...state,
                        isLoaded: false,
                        error
                    }
                });
            }
        );
}