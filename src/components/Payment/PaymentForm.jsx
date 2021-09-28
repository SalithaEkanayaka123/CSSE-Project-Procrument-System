import React from 'react'
import {Button, FormControl, Grid, InputLabel, makeStyles, MenuItem, Select, TextField} from "@material-ui/core";

const useStyles = makeStyles(theme => ({
    root: {
        '& .MuiFormControl-root': {
            width: '60ch',
            margin: theme.spacing(1)
        }
    }
}))

const PaymentForm = () => {

    const classes = useStyles();
    return (
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
                <Button
                    style={{ marginLeft: "15px"}}
                    variant="contained"
                    color="primary"
                    size="large"
                    // onClick={handleReset}
                >
                    SUBMIT
                </Button>
                <Button
                    style={{ marginLeft: "15px"}}
                    variant="contained"
                    color="secondary"
                    size="large"
                >
                    RESET
                </Button>
            </Grid>
        </form>
    )
}

export default PaymentForm
