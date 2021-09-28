import React, { useState, useEffect } from "react";
import {
    Grid,
    FormControl,
    FormLabel,
    RadioGroup,
    FormControlLabel,
    Radio,
    Box,
    TextField, makeStyles,
} from "@material-ui/core";

const useStyles = makeStyles(theme => ({
    root: {
        '& .MuiFormControl-root': {
            width: '60ch',
            margin: theme.spacing(1)
        }
    }
}))
const UserManagementForm = () => {

    const classes = useStyles();

    return(
        <form className={classes.root}>
            <Grid container spacing={2}>
                <Grid item xs={12} sm={6}>
                    <TextField id="outlined-basic" label="Outlined" variant="outlined" />
                </Grid>
                <Grid item xs={12} sm={6}>
                    <TextField id="outlined-basic" label="Outlined" variant="outlined" />
                </Grid>
                <Grid item xs={12} sm={6}>
                    <TextField id="outlined-basic" label="Outlined" variant="outlined" />
                </Grid>
                <Grid item xs={12} sm={6}>
                    <TextField id="outlined-basic" label="Outlined" variant="outlined" />
                </Grid>
                <Grid item xs={12} sm={6}>
                    <TextField id="outlined-basic" label="Outlined" variant="outlined" />
                </Grid>
                <Grid item xs={12} sm={6}>
                    <TextField id="outlined-basic" label="Outlined" variant="outlined" />
                </Grid>
            </Grid>
        </form>
    )






}

export default UserManagementForm;