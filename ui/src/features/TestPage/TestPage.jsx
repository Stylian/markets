import {useDispatch, useSelector} from "react-redux";
import React from "react";
import styles from './TestPage.module.css';
import {
    addTest, selectRuns,
} from './testPageSlice';

export function TestPage() {
    const dispatch = useDispatch();
    const runningTimes = useSelector(selectRuns);

    return (
        <div className={styles.main}>
            <button
                onClick={() => dispatch(addTest())}
            > Test </button>
            {runningTimes}
        </div>
    );
}