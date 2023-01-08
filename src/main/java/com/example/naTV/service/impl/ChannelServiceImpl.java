package com.example.naTV.service.impl;

import com.example.naTV.exception.NotFoundExcep;
import com.example.naTV.exception.Save4Exception;
import com.example.naTV.mapper.EntityAndDTO.ChannelMapper;
import com.example.naTV.microService.MicroService4Image;
import com.example.naTV.models.dto.ChannelDto;
import com.example.naTV.models.entity.Channel;
import com.example.naTV.models.repository.ChannelRepository;
import com.example.naTV.models.response.GetChannalRespnonse;
import com.example.naTV.service.Interface.ChannelService;
import com.example.naTV.service.Interface.DiscountService;
import com.example.naTV.service.Interface.PriceService;
import com.example.naTV.utils.RBundle;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChannelServiceImpl extends BaseServiceImpl<Channel, ChannelDto> implements ChannelService {
    private final ChannelRepository rep;
    private final MicroService4Image microService4Image;
    private final PriceService priceService;


    private final ChannelMapper mapper = ChannelMapper.INSTANCE;

    private ChannelServiceImpl(ChannelRepository rep, MicroService4Image microService4Image, PriceService priceService) {
        super(rep, ChannelMapper.INSTANCE);
        this.rep = rep;
        this.microService4Image = microService4Image;
        this.priceService = priceService;
    }

    @Override
    public List<GetChannalRespnonse> getChannels(Pageable pageable) {
        return rep.findAlll(pageable).getContent();
    }


    @Override
    public ChannelDto save(String name, int orderNum, MultipartFile photo, Double price) throws NotFoundExcep {
        if (rep.existsByName(name))
            throw new Save4Exception(RBundle.SINGILTON.periodMessage("channelNameExist"));//TODO Нужно добавить текст в properties
        if (rep.existsByOrderNum(orderNum))
            throw new Save4Exception(RBundle.SINGILTON.periodMessage("notFound"));//TODO Нужно добавить текст в properties
        ChannelDto dto = new ChannelDto();
        dto.setName(name);
        dto.setOrderNum(orderNum);
        dto.setPhoto(microService4Image.upload(photo).getDownloadUri());
        priceService.save(dto,price);
        return super.save(dto);
    }

}
