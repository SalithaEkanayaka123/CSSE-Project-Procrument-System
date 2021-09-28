import React from 'react'
import {Grid, makeStyles} from "@material-ui/core";
import Paper from "@mui/material/Paper";


const useStyles = makeStyles(theme => ({
    container: {
        display: "flex"
    },
    gridview1: {
        width: '80vw',
        marginLeft: 'auto',
        marginRight: 'auto',
        marginTop: '2vw',
        marginBottom: '2vw'
    },
    headerValues: {
        fontSize: '25px',
        color: '#022346'
        //fontFamily: ''

    },
    headerValues1: {
        fontSize: '25px',
        //fontFamily: ''

    }
}))


const PaymentHeader = () => {

    const classes = useStyles();
    return (
        <div className={classes.container}>
            <Grid container className={classes.gridview1} spacing={4} justify="flex-start">
                <Grid item xs={12} sm={6} md={1} lg={4}>
                        <h1 className={classes.headerValues}>Date</h1>
                </Grid>
                <Grid item xs={12} sm={6} md={1} lg={4}>
                        <h1 className={classes.headerValues}>Description</h1>
                </Grid>
                <Grid item xs={12} sm={6} md={1} lg={4}>
                        <h1 className={classes.headerValues}>Invoice Number</h1>
                </Grid>
                <Grid item xs={12} sm={6} md={1} lg={4}>
                        <h1 className={classes.headerValues1}>2021-09-28</h1>
                </Grid>
                <Grid item xs={12} sm={6} md={1} lg={4}>
                        <h1 className={classes.headerValues1}>Payment Description</h1>
                </Grid>
                <Grid item xs={12} sm={6} md={1} lg={4}>
                        <h1 className={classes.headerValues1}>US-001</h1>
                </Grid>

            </Grid>
        </div>
    )
}

export default PaymentHeader
