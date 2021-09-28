import React, { useState, useEffect } from "react";
import SearchBar, {SearchBarProps} from "material-ui-search-bar";
import {makeStyles, TextField} from "@material-ui/core";

const useStyles = makeStyles(theme => ({
    maindiv: {
        marginTop:'20px',
        width: "100%",
        height:'70px'
    },
    search: {
        "SearchBarProps":{
            color: '#FFFFFF',
        }
    }
}))

const Searchbar =() =>{
    const classes = useStyles();
    return(
        <div className={classes.maindiv}>
            <SearchBar
                onChange={() => console.log("onChange")}
                onRequestSearch={() => console.log("onRequestSearch")}
                classes={classes.search}
                style={{
                    margin: "0 40px",
                    minWidth: 400,
                    color: "white",
                    backgroundColor: "#585858",
                    fontcolor: "white",


                }}
                SearchBarProps={{
                    color: '#fff',
                }}

            />
        </div>
    )

}
export default Searchbar