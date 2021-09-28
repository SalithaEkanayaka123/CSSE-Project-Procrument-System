import React from 'react'
import TableContainer from "@mui/material/TableContainer";
import Paper from "@mui/material/Paper";
import Table from "@mui/material/Table";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import TableCell from "@mui/material/TableCell";
import TableBody from "@mui/material/TableBody";
import {makeStyles} from "@material-ui/core";


function createData(name, calories, fat, carbs, protein, protein2) {
    return { name, calories, fat, carbs, protein, protein2 };
}

const rows = [
    createData('Frozen yoghurt', 159, 6.0, 24, 4.0, 5),
    createData('Frozen yoghurt', 159, 6.0, 24, 4.0, 5),
    createData('Frozen yoghurt', 159, 6.0, 24, 4.0, 5),
];

const useStyles = makeStyles({
    table: {
        borderRadius: 8.74,
    },
    teacherContent: {
        borderRadius: 8.74,
        minWidth: "810px"
    },
    userTableHeader: {
        color: 'white',
        width: '200px',
    },
});

const PaymentBody = () => {

    const classes = useStyles();
    return (
        <React.Fragment>
            <TableContainer component={Paper} className={classes.teacherContent}>
                <Table className={classes.table} aria-label="simple table">
                    <TableHead className="teacher-table-header">
                        <TableRow>
                            <TableCell align="center" className={classes.userTableHeader}>ItemName</TableCell>
                            <TableCell align="center" className={classes.userTableHeader}>Quantiy</TableCell>
                            <TableCell align="center" className={classes.userTableHeader}>Amount (perI)</TableCell>
                            <TableCell align="center" className={classes.userTableHeader}>Total Amount</TableCell>
                            <TableCell align="center" className={classes.userTableHeader}>Discount</TableCell>
                            <TableCell align="center" className={classes.userTableHeader}>Net Amount</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {rows.map((row) => (
                            <TableRow
                                key={row.name}
                                sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                            >
                                <TableCell align="center" component="th" scope="row">
                                    {row.name}
                                </TableCell>
                                <TableCell align="center">{row.calories}</TableCell>
                                <TableCell align="center">{row.calories}</TableCell>
                                <TableCell align="center">{row.carbs}</TableCell>
                                <TableCell align="center">{row.protein}</TableCell>
                                <TableCell align="center">{row.protein2}</TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        </React.Fragment>
    )
}

export default PaymentBody
