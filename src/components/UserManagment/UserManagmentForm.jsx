import React, { useState, useEffect } from "react";
import {
    Grid,
    FormControl,
    TextField, makeStyles, InputLabel, Select, MenuItem,
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
                    <TextField id="outlined-basic" label="User name" variant="outlined" />
                </Grid>
                <Grid item xs={12} sm={6}>
                    <TextField id="outlined-basic" label="Phone number" variant="outlined" />
                </Grid>
                <Grid item xs={12} sm={6}>
                    <TextField id="outlined-basic" label="First Name" variant="outlined" />
                </Grid>
                <Grid item xs={12} sm={6}>
                    <FormControl variant="outlined" className={classes.formControl}>
                        <InputLabel id="demo-simple-select-outlined-label">Age</InputLabel>
                        <Select
                            labelId="demo-simple-select-outlined-label"
                            id="demo-simple-select-outlined"
                            // value={age}
                            // onChange={handleChange}
                            label="Age"
                        >
                            <MenuItem value="">
                                <em>None</em>
                            </MenuItem>
                            <MenuItem value={10}>Ten</MenuItem>
                            <MenuItem value={20}>Twenty</MenuItem>
                            <MenuItem value={30}>Thirty</MenuItem>
                        </Select>
                    </FormControl>
                </Grid>
                <Grid item xs={12} sm={6}>
                    <TextField id="outlined-basic" label="Last Name" variant="outlined" />
                </Grid>
                <Grid item xs={12} sm={6}>
                    <TextField id="outlined-basic" label="Password" variant="outlined" type="password"/>
                </Grid>
            </Grid>
        </form>
    )






}

export default UserManagementForm;