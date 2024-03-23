// import logo from "../../assets/img/logo-payment.png";
import useMediaQuery from '../../hooks/useMediaQuery.js'
import { BsArrowLeft } from 'react-icons/bs';

const NavbarPayment = () => {

  const isMobile = useMediaQuery('(max-width: 640px)')

  return (
    <>
      <div className="bg-secondary h-[103px] sm:h-[56px] flex items-center">
        <nav className="flex w-full mx-6 sm:mx-24">
          {
            isMobile ?
              <div className="text-center w-full flex items-center justify-center">
                <BsArrowLeft size="25px" />
                <p className="text-2xl font-light p-10">{/*title*/}</p>
              </div>

              : <div className="flex items-center justify-between w-full">
                <div>
                  <img /*src={logo}*/ alt="Mercado Libre logo" />
                </div>
                <div>
                  <span className="font-light">Ayuda</span>
                </div>
              </div>
          }
        </nav>
      </div>
    </>
  )
}

export default NavbarPayment
