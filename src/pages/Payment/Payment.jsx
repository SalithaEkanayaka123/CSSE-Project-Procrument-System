import React from 'react'
import PaymentHeader from "../../components/Payment/PaymentHeader";
import PageHeader from "../../components/PageHeader/PageHeader";
import PeopleOutlineTwoToneIcon from "@material-ui/icons/PeopleOutlineTwoTone";
import Searchbar from "../../components/Searchbar/Searchbar";
import {Divider, makeStyles, Paper} from "@material-ui/core";
import UserManagmentForm from "../../components/UserManagment/UserManagmentForm";
import UserManagmentTable from "../../components/UserManagment/UserManagmentTable";
import PaymentBody from "../../components/Payment/PaymentBody";
import PaymentForm from "../../components/Payment/PaymentForm";



const useStyles = makeStyles(theme => ({
    pageContent: {
        margin: theme.spacing(5),
        padding: theme.spacing(3)
    }
}))
const Payment = () => {

    const classes = useStyles();
    return (
        <div>
            <PageHeader
                title="Payment Management"
                subTitle="Handle Payment"
                icon={<PeopleOutlineTwoToneIcon fontSize="large" />}
            />
            <PaymentHeader/>
            <Divider style={{margin: `14px 0`}} />
            <Searchbar/>
            <div style={{width:'1500px', marginLeft:'120px'}}>
                <paper>
                    <PaymentBody/>
                </paper>

            </div>

            <Divider style={{margin: `14px 0`}} />
            <Paper className={classes.pageContent}>
                <PaymentForm/>
            </Paper>
        </div>
    )
}

export default Payment
