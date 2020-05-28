package co.edu.icesi.fi.tics.tssc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.fi.tics.tssc.daos.ITsscTimecontrolDao;
import co.edu.icesi.fi.tics.tssc.model.TsscGame;
import co.edu.icesi.fi.tics.tssc.model.TsscTimecontrol;

@Service
public class TsscTimecontrolServiceImp implements TsscTimecontrolService{

	private ITsscTimecontrolDao timeDao;
	
	@Autowired
	public TsscTimecontrolServiceImp(ITsscTimecontrolDao timeDao) {
		this.timeDao = timeDao;
	}
	
	@Override
	public TsscTimecontrol saveTime(TsscTimecontrol newTime) {
		// TODO Auto-generated method stub
		timeDao.save(newTime);
		return newTime;
	}

	@Override
	public TsscTimecontrol editTime(TsscTimecontrol newTime) {
		// TODO Auto-generated method stub
		timeDao.update(newTime);
		return newTime;
	}

	@Override
	public Iterable<TsscTimecontrol> findAll() {
		// TODO Auto-generated method stub
		return timeDao.findAll();
	}

	@Override
	public Optional<TsscTimecontrol> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.of(timeDao.findById(id));
	}

	@Override
	public void delete(TsscTimecontrol time) {
		// TODO Auto-generated method stub
		timeDao.delete(time);
	}

	@Override
	public TsscTimecontrol saveTimeGame(TsscTimecontrol newTime, TsscGame game) {
		if(game != null) {
			newTime.setTsscGame(game);
			timeDao.save(newTime);
			return newTime;
		} else {
			return saveTime(newTime);
		}
	}

	@Override
	public TsscTimecontrol editTimeGame(TsscTimecontrol newTime, TsscGame game) {
		if(game != null) {
			newTime.setTsscGame(game);
			timeDao.update(newTime);
			return newTime;
		} else {
			return editTime(newTime);
		}
	}

	@Override
	public TsscGame getGame(TsscTimecontrol time) {
		// TODO Auto-generated method stub
		return time.getTsscGame();
	}

}
