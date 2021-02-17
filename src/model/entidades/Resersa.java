package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.excecoes.DominioExcecoes;

public class Resersa {
	private Integer ReservaNumero;
	private Date checkIn;
	private Date checkOut;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Resersa(Integer reservaNumero, Date checkIn, Date checkOut) {
		if(!checkOut.after(checkIn)) {
			throw  new DominioExcecoes( "Erro reserva da anteriro a data do chekin");
					}
		ReservaNumero = reservaNumero;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
	}
	public Integer getReservaNumero() {
		return ReservaNumero;
	}
	public void setReservaNumero(Integer reservaNumero) {
		ReservaNumero = reservaNumero;
	}
	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duração() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	
	}
	
	public void alterarDatas(Date checkIn, Date checkOut) {
		 Date agora = new Date ();
		 if (checkIn.before(agora)|| checkOut.before(agora)) {
		throw  new DominioExcecoes("Erro na reserva, as datas não podem ser anteriores");
		 }
		 if(!checkOut.after(checkIn)) {
		throw  new DominioExcecoes( "Erro reserva da anteriro a data do chekin");
				}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	

	@Override
	public String toString () {
		return "Reserva " + ReservaNumero
				+ ", checkIn-in: "
				+ sdf.format(checkIn)
				+ ", checkIn-out: "
				+ sdf.format(checkOut) 
				+ ", "
				+ duração()
				+ "Noites";
				
	}
	
}
