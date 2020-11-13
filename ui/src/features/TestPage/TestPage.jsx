import {useDispatch, useSelector} from "react-redux";
import React, {useEffect} from "react";
import styles from './TestPage.module.css';
import {
    getTests,
    postTest,
} from './testPageSlice';

export function TestPage() {
    const dispatch = useDispatch();
    const isLoaded = useSelector(state => state.testPage.isLoaded);
    const hasRun = useSelector(state => state.testPage.hasRun);
    const tests = useSelector(state => state.testPage.tests);
    const something = useSelector(state => state.testPage.something);
    
    useEffect( () => {
        dispatch(getTests());
    }, [dispatch]);
    
    return isLoaded ? (
        <div className={styles.main}>
            {tests.map((test, k) => (<div key={k}>{test.counter}</div>))}
            <button
                onClick={() => dispatch(postTest())}
            > Test </button>
            <div>{hasRun}</div>
            <div>{something}</div>
        </div>
    ) : (null);
}