import React, { useEffect, useState } from 'react';
import { Container, Grid, Card, CardContent, Typography, CardActions, Button } from '@mui/material';
import 'react-toastify/dist/ReactToastify.css';
import { useParams } from 'react-router-dom';
import { axiosGetItemsOrderId } from '../Service-Components/ServiceOrder';
import { useHistory } from 'react-router-dom';
import DisplayImage from '../Admin-Product-Component/DisplayImage';


const OrderedItems = () => {


  const [CartItems, setCartItems] = useState([]);
  useEffect(() => {
    getCartItems();
  },[])//eslint-disable-line
  const history = useHistory();
  const { id } = useParams();
  const getCartItems = async () => {
    const response = await axiosGetItemsOrderId(id);
    console.log(response);
    setCartItems(response.data.orderedCartDTO.cartItems);
    console.log(CartItems);
  }

  const GoBack = async () => {

    history.push("/allorders")
  }

  return (
    <div >
      <div >
        <Button className='back-btn' variant="contained" color="primary" align="center" onClick={() => GoBack()}>Back</Button>
      </div>

      <div className='cardcontainer'>

        <Container >

          <Grid container spacing={3} >
            {Array.isArray(CartItems) && CartItems.length > 0 ? (
              CartItems.map((data) => (
                <Grid item key={data.product.productId} xs={12} sm={6} md={4} lg={3}>
                  <Card>
                    <div className="image-container">
                      <div className="image-wrapper">
                        <DisplayImage image={data.product.productImage} />
                        <div className="hover-effect"></div>
                      </div>
                    </div>
                    <CardContent>
                      <Typography variant="h6">{data.product.productName}</Typography>
                      <Typography variant="body2" color="textSecondary">
                        <b>Price: {data.product.productPrice}</b><br />
                        <b>Quantity: {data.quantity}</b>
                      </Typography>
                    </CardContent>
                    <CardActions>

                    </CardActions>
                  </Card>
                </Grid>
              )))
              :
              (
                <p>Your cart is empty.</p>
              )
            }
          </Grid>
        </Container>
      </div>
    </div>
  )

}

export default OrderedItems;