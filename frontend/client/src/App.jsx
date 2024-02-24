import { Route, Routes } from 'react-router-dom'
import Home from './pages/Home'
import ProductDetail from './pages/ProductDetail'
import Payment from './pages/Payment'
import Warranty from './pages/payments/Warranty'
import DeliveryType from './pages/payments/DeliveryType'
import HomeDelivery from './pages/payments/HomeDelivery'
import DeliveryPoint from './pages/payments/DeliveryPoint'
import PayMethod from './pages/payments/PayMethod'
import PayConfirmed from './pages/payments/PayConfirmed'
import Footer from './components/Footer/Footer'

function App() {
  return (
    <>
    <Routes>
      <Route path='/' element={<Home/>} />
      <Route path='product-detail/:id' element={<ProductDetail/>} />
      <Route path="/warranty" element={<Warranty/>} />
      <Route path="/delivery-type" element={<DeliveryType/>} />
      <Route path="/home-delivery" element={<HomeDelivery/>} />
      <Route path="/point-delivery" element={<DeliveryPoint/>} />
      <Route path="/pay-method" element={<PayMethod/>} />
      <Route path='/payment' element={<Payment/>} />
      <Route path="/pay-confirmed" element={<PayConfirmed/>} />
    </Routes>
    <Footer />
    </>
  )
}

export default App
