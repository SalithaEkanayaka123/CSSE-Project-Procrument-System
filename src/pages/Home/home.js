import React, { useState, useEffect } from "react";
import {makeStyles} from "@material-ui/core";

const useStyles = makeStyles(theme => ({
    pageContent: {
        margin: theme.spacing(5),
        padding: theme.spacing(3)
    }
}))

const Home =() =>{
    const classes = useStyles();
    return(
        <div>

        </div>
    )

}
export default Home