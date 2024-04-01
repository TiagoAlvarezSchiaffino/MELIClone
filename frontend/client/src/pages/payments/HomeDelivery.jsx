import NavbarPayment from '../../components/Payments/NavbarPayment'
import ProductDetailPayment from '../../components/Payments/ProductDetailPayment'
import FormNewAdress from '../../components/Payments/FormNewAddress'

const HomeDelivery = () => {
  return (
    <>
      <section className='bg-[#eeeeee]'>
        <NavbarPayment title={'Agregá un domicilio'} />

        <div className='flex justify-around gap-7 flex-wrap 2xl:mx-32'>
          <FormNewAdress />
          <ProductDetailPayment />
        </div>
      </section>
    </>
  )
}

export default HomeDelivery
