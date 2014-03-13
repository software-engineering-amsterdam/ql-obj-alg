form Box1HouseOwning {
	valueResidue: "Value residue:" integer
	value4: "value4" integer (valueResidue+1)
	value5: "value5" integer (value4+1)
	
	if(valueResidue > 50){
		value6: "value6" boolean 
	}else{
		value7: "value7" boolean
	}
}