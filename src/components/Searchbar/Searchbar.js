import React, { useState, useEffect } from "react";
import {makeStyles, TextField} from "@material-ui/core";

const useStyles = makeStyles(theme => ({
    maindiv: {
        background:'#585858',
        width: "100%",
        height:'100px'
    }
}))

const Searchbar =() =>{
    const classes = useStyles();
    return(
        <div className={classes.maindiv}>
            <TextField id="outlined-basic" label="User name" variant="outlined" />
        </div>
    )

}
export default Searchbar