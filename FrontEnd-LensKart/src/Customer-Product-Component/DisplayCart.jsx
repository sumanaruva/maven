import React, { useEffect, useState } from 'react';
import { useHistory } from 'react-router-dom';
import { Container, Grid, Card, CardContent, Typography, Button } from '@mui/material';
import { axiosAddToCart, axiosDeleteProductCart } from '../Service-Components/ServiceCart';
import { axiosGetCart } from '../Service-Components/ServiceUser';
import { axiosPlaceOrder } from '../Service-Components/ServiceOrder';
import DisplayImageCust from './DisplayImageCust';


const DisplayCart = () => {
  const history = useHistory();
  const [cartItem, setCartItem] = useState({});
  const [cart, setCart] = useState({});

  useEffect(() => {
    getCarts();
  },[])//eslint-disable-line

  const getCarts = async () => {

    let custid = sessionStorage.getItem('id');
    const response = await axiosGetCart(custid);
    console.log(response);
    setCartItem(response.data.cartItems);
    setCart(response.data)
    console.log(cartItem);
  }


  const addToCart = async (id) => {
    let custid = sessionStorage.getItem('id');
    await axiosAddToCart(custid, id);
    getCarts();
    history.push('/cart');


  }

  const deleteProductCart = async (id) => {
    let custid = sessionStorage.getItem('id');
    await axiosDeleteProductCart(custid, id);
    getCarts();
    history.push('/cart');


  }
  const placeOrder = async () => {
    let custid = sessionStorage.getItem('id');
    await axiosPlaceOrder(custid);
    history.push('/viewproducts');


  }

  return (
    <div >
      <div className='total-display'><b>totalprice:{cart.totalPrice} </b></div>
      {
        cart.totalPrice > 0 ? <Button className='place' onClick={() => placeOrder()} variant="contained" color="secondary" size="small"><strong>Place Order</strong></Button> : ""



      }
      <div className='cardcontainer1'>

        <Container >

          <Grid container spacing={3} >
            {Array.isArray(cartItem) && cartItem.length > 0 ? (
              cartItem.map((cartitem) => (
                <Grid item key={cartitem.product.productId} xs={12} sm={6} md={4} lg={3}>
                  <Card>

                    <div className="image-container">
                      <div className="image-wrapper">
                        <DisplayImageCust image={cartitem.product.productImage} />
                        <div className="hover-effect"></div>
                      </div>
                    </div>
                    <CardContent>
                      <Typography variant="h6">{cartitem.product.productName}</Typography>
                      <Typography variant="body2" color="textSecondary">
                        Price: {cartitem.product.productPrice}
                      </Typography>
                    </CardContent>
                    <Button className='inc' onClick={() => addToCart(cartitem.product.productId)} variant="contained" color="primary" size="small" ><strong>+</strong></Button>

                    <b className='quanty'>{cartitem.quantity}</b>
                    <Button className='dec' onClick={() => deleteProductCart(cartitem.product.productId)} variant="contained" color="secondary" size="small"><strong>-</strong></Button>

                  </Card>

                </Grid>


              )))
              :
              (
                <div className='cart-em'><h4>Your cart is empty.</h4> </div>
              )
            }

          </Grid>
        </Container>
        <u />


      </div>


    </div>

  )

}

export default DisplayCart;