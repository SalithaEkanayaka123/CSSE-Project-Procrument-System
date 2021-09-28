import React, { useState, useEffect } from "react";
import {Divider, Grid, makeStyles, Paper} from "@material-ui/core";
import UserManagmentForm from "../../components/UserManagment/UserManagmentForm";
import PageHeader from "../../components/PageHeader/PageHeader";
import PeopleOutlineTwoToneIcon from '@material-ui/icons/PeopleOutlineTwoTone';
import UserManagmentTable from "../../components/UserManagment/UserManagmentTable";
const useStyles = makeStyles(theme => ({
    pageContent: {
        margin: theme.spacing(5),
        padding: theme.spacing(3)
    }
}))
const UserManagment = () => {
    const classes = useStyles();

    return (
        <>
            <PageHeader
                title="User Management"
                subTitle="New user can add using this form"
                icon={<PeopleOutlineTwoToneIcon fontSize="large" />}
            />
            <Paper className={classes.pageContent}>
                <UserManagmentForm />
            </Paper>
                <Divider style={{margin: `14px 0`}} />
                <div style={{width:'1500px', marginLeft:'120px'}}>
                    <paper>
                        <UserManagmentTable/>
                    </paper>

                </div>

        </>
    );
}

export default UserManagment;


