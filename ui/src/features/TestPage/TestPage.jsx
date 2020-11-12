import {useDispatch, useSelector} from "react-redux";
import React, {useEffect} from "react";
import styles from './TestPage.module.css';
import {
    getTests,
    postTest,
    selectIsLoaded,
    selectRuns,
    selectTests,
} from './testPageSlice';
import {loadBuyingClients, loadSellingClients} from "../TradeCenter/tradeCenterSlice";

export function TestPage() {
    const dispatch = useDispatch();
    const isLoaded = useSelector(selectIsLoaded);
    const runningTimes = useSelector(selectRuns);
    const tests = useSelector(selectTests);
    
    useEffect( () => {
        dispatch(getTests())
    }, [dispatch]);
    
    return isLoaded ? (
        <div className={styles.main}>
            {/*{tests.map(test => <p>{test}</p>)}*/}
            {tests[0].counter}
            <button
                onClick={() => dispatch(postTest())}
            > Test </button>
            {runningTimes}
        </div>
    ) : (null);
}