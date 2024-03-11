const DescriptionBottom=({description})=>{
    return(
        <div className="my-2 p-1">
            <h2 className="text-black text-3xl">Descripción</h2>
            {description.map((elem)=>{
                return(
                    <p className="text-gray-500 py-3 text-xl">{elem}</p>
                )
            })}
        </div>
    )
}

export default DescriptionBottom
