import * as React from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import {makeStyles} from "@material-ui/core";
import "./userManagement.scss";
function createData(name, calories, fat, carbs, protein) {
    return { name, calories, fat, carbs, protein };
}

const rows = [
    createData('Frozen yoghurt', 159, 6.0, 24, 4.0),
    createData('Ice cream sandwich', 237, 9.0, 37, 4.3),
    createData('Eclair', 262, 16.0, 24, 6.0),
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

export default function UserManagmentTable() {

    const classes = useStyles();

    return (
        <React.Fragment>
            <TableContainer component={Paper} className={classes.teacherContent}>
                <Table className={classes.table} aria-label="simple table">
                    <TableHead className="teacher-table-header">
                        <TableRow>
                            <TableCell align="center" className={classes.userTableHeader}>Name</TableCell>
                            <TableCell align="center" className={classes.userTableHeader}>Email</TableCell>
                            <TableCell align="center" className={classes.userTableHeader}>Age</TableCell>
                            <TableCell align="center" className={classes.userTableHeader}>User Name</TableCell>
                            <TableCell align="center" className={classes.userTableHeader}>Status</TableCell>
                        </TableRow>
                    </TableHead>
                        <TableBody>
                            {rows.map((row) => (
                                <TableRow
                                key={row.name}
                                sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                                >
                                <TableCell component="th" scope="row">
                            {row.name}
                                </TableCell>
                                <TableCell align="right">{row.calories}</TableCell>
                                <TableCell align="right">{row.calories}</TableCell>
                                <TableCell align="right">{row.carbs}</TableCell>
                                <TableCell align="right">{row.protein}</TableCell>
                                </TableRow>
                                ))}
                        </TableBody>
                    </Table>
            </TableContainer>
        </React.Fragment>
       );
}


